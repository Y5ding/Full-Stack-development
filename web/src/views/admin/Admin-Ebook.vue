<template>
  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <a-table
          :columns="columns"
          :row-key="record => record.id"
          :data-source="ebooks"
          :pagination="pagination"
          :loading="loading"
          @change="handleTableChange"
      >
        <template #cover="{ text: cover }">
          <img v-if="cover" :src="cover" alt="avatar" />
        </template>
        <template v-slot:action="{ text, record }">
          <a-space size="small">
              <a-button type="primary" @click="edit(record)">
                edit
              </a-button>
            <a-popconfirm
                title="删除后不可恢复，确认删除?"
                ok-text="是"
                cancel-text="否"
                @confirm="del(record.id)"
            >
             <a-button type="danger">
                 delete
             </a-button>
            </a-popconfirm>
          </a-space>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>
  <a-modal
      title="电子书表单"
      v-model:visible="modalVisible"
      :confirm-loading="modalLoading"
      @ok="handleModalOk"
      >
    <a-form :model="ebook" :label-col="{ span: 6}" >
      <a-form-item label="cover">
        <a-input v-model:value="ebook.cover" />
      </a-form-item>
      <a-form-item label="name">
        <a-input v-model:value="ebook.name" />
      </a-form-item>
      <a-form-item label="分类一">
        <a-input v-model:value="ebook.category1" />
      </a-form-item>
      <a-form-item label="分类二">
        <a-input v-model:value="ebook.category2" />
      </a-form-item>
      <a-form-item label="描述">
        <a-input v-model:value="ebook.description" />
      </a-form-item>
    </a-form>>
  </a-modal>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import { message } from 'ant-design-vue';
import axios from 'axios';

export default defineComponent({
  name: 'AdminEbook',
  setup() {
    const ebooks = ref();
    const pagination = ref({
      current: 1,
      pageSize: 100,
      total: 0
    });
    const loading = ref(false);

    const columns = [
      {
        title: 'Cover',
        dataIndex: 'cover',
        slots: { customRender: 'cover' }
      },
      {
        title: 'Name',
        dataIndex: 'name'
      },
      {
        title: 'Category1',
        slots: { customRender: 'category1' }
      },
      {
        title: 'Category2',
        slots: { customRender: 'category2' }
      },
      {
        title: 'Count',
        dataIndex: 'docCount'
      },
      {
        title: 'View',
        dataIndex: 'viewCount'
      },
      {
        title: 'Vote',
        dataIndex: 'voteCount'
      },
      {
        title: 'Action',
        key: 'action',
        slots: { customRender: 'action' }
      }
    ];
    //query database
    const handleQuery = (params: any) => {
      loading.value = true;
      ebooks.value = [];
      axios.get("/ebook/list", {
        params: params
      }).then((response) => {
        loading.value = false;
        const data = response.data;
        if (data.success) {
          ebooks.value = data.content.list;
          //reset pagination
          pagination.value.current = params.page;
          pagination.value.total = data.content.total;
        }else {
          message.error(data.message);
        }
      });
    };

    //pagination
    const handleTableChange = (pagination: any) => {
      console.log("pagination parameter：" + pagination);
      handleQuery({
        page: pagination.current,
        size: pagination.pageSize
      });
    };
    // -------- 表单 ---------
    const ebook=ref({});
    const modalVisible = ref(false);
    const modalLoading = ref(false);
    const handleModalOk = () => {
      modalLoading.value = true;
      /*setTimeout(() => {
      }, 2000);*/
      axios.post("/ebook/save", ebook.value).then((response) => {
        modalLoading.value = false;
        const data = response.data; // data = commonResp
        if (data.success) {
          modalVisible.value = false;
          //overload data and table
          handleQuery({
            page: pagination.value.current,
            size: pagination.value.pageSize,
          });
        }
      });
    };

    const edit=(record:any) =>{
       modalVisible.value = true;
       ebook.value=record
     }
    const del=(id:number) => {
      axios.delete("/ebook/delete/" + id).then((response) => {
        const data = response.data; // data = commonResp
        if (data.success) {
          handleQuery({
            page: pagination.value.current,
            size: pagination.value.pageSize,
          });
        }
      });
    };

    onMounted(() => {
      handleQuery({
        page: 1,
        size: pagination.value.pageSize
      });
    });

    return {
      ebooks,
      pagination,
      columns,
      loading,
      handleTableChange,
      edit,
      modalLoading,
      modalVisible,
      handleModalOk,
      ebook,
      del,

    }
  }
});
</script>

<style scoped>
img {
  width: 50px;
  height: 50px;
}
</style>
