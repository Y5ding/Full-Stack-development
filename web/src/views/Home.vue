<template>
  <a-layout>
    <a-layout-sider width="200" style="background: #fff">
        <a-menu
            mode="inline"
            :style="{width: '256px'}"
        >
          <a-sub-menu key="sub1">
            <span slot="title"><a-icon type="mail" /><span>Navigation One</span></span>
            <a-menu-item key="1">
              Option 11
            </a-menu-item>
            <a-menu-item key="2">
              Option 2
            </a-menu-item>
            <a-menu-item key="3">
              Option 3
            </a-menu-item>
            <a-menu-item key="4">
              Option 4
            </a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub2">
            <span slot="title"><a-icon type="appstore" /><span>Navigation Two</span></span>
            <a-menu-item key="5">
              Option 5
            </a-menu-item>
            <a-menu-item key="6">
              Option 6
            </a-menu-item>
            <a-sub-menu key="sub3" title="Submenu">
              <a-menu-item key="7">
                Option 7
              </a-menu-item>
              <a-menu-item key="8">
                Option 8
              </a-menu-item>
            </a-sub-menu>
          </a-sub-menu>
          <a-sub-menu key="sub4">
            <span slot="title"><a-icon type="setting" /><span>Navigation Three</span></span>
            <a-menu-item key="9">
              Option 9
            </a-menu-item>
            <a-menu-item key="10">
              Option 10
            </a-menu-item>
            <a-menu-item key="11">
              Option 11
            </a-menu-item>
            <a-menu-item key="12">
              Option 12
            </a-menu-item>
          </a-sub-menu>
        </a-menu>
    </a-layout-sider>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }">
      Content 33
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import axios from 'axios';
export default defineComponent({
  name: 'home',
  setup(){
    console.log("set up");
    axios.get("http://localhost:8080/ebook/list?name=Java").then(function (response){console.log(response);})
  }
});
</script>

<style>
#components-layout-demo-top-side-2 .logo {
  width: 120px;
  height: 31px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px 28px 16px 0;
  float: left;
}
</style>
