<template>
    <el-container>
      <el-header height="150px">
        <el-image
          style="margin-left: 0px; margin-top: 40px"
          :src="require('../assets/logo.png')"
        ></el-image>
        <el-menu
          default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          style="margin-top: -60px; margin-left: 250px"
        >
          <el-menu-item
            v-for="item in button_list"
            :key="item.name"
            index="item.name"
            @click="goPage(item.path)"
            style="font-size: 35px; width: 13%"
          >
            <template slot="title">
              <span style="font-size: 20px">{{ item.name }}</span>
            </template>

          </el-menu-item>
        </el-menu>
      </el-header>

      <el-container>
        <el-aside>

        </el-aside>

        <el-main>

        </el-main>
      </el-container>
    </el-container>
</template>

<script>

</script>

<style scoped>

</style>
