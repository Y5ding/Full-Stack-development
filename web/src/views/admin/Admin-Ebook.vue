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
        <template v-slot:category="{ text, record }">
          <span>{{ getCategoryName(record.category1Id) }} / {{ getCategoryName(record.category2Id) }}</span>
        </template>
        <template v-slot:action="{ text, record }">
          <a-space size="small">
              <a-button type="primary">
                edit
              </a-button>
            <a-button type="danger">
              delete
            </a-button>
          </a-space>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import axios from 'axios';

export default defineComponent({
  name: 'AdminEbook',
  setup() {
    const ebooks = ref();
    const pagination = ref({
      current: 1,
      pageSize: 10,
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
        title: 'Category',
        slots: { customRender: 'category' }
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
      axios.get("/ebook/list",params).then((response) => {
        loading.value = false;
        const data = response.data;
          ebooks.value = data.content;
          //reset pagination
          pagination.value.current = params.page;
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

    onMounted(() => {
      handleQuery({});
    });

    return {
      ebooks,
      pagination,
      columns,
      loading,
      handleTableChange,
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
