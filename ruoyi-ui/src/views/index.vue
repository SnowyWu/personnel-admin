<template>
 <div>
  <div class="home">
    <h2>人事后台管理系统</h2>
    <p>基于ruoyi-vue快速开发的一个系统</p>
 </div>

 <div class="card">
        <img src="https://snowywu.github.io/img/home.jpg" alt="foo" class="header">
        <h1>snowWu</h1>
        <p>我是一位热爱编程的技术爱好者。目前我的技术栈包括 typescript、HTML、CSS、Node.js、React,SpringBoot 等。</p>
        <p>如果你有任何问题或好的意见，欢迎发邮件至 <a href="mailto:2972561826@qq.com">2972561826@qq.com</a> 与我联系。</p>
    </div>
 </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.5"
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    }
  }
};
</script>

<style scoped lang="css">
.card {
    background-color: #fff;
    padding: 30px;
    width: 80%;
    max-width: 800px;
    margin: 130px auto;
    text-align: center;
}

.header {
    width: 200px;
    height: 200px;
    border: 5px solid #eee;
    border-radius: 50%;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
    margin-bottom: 20px;
}

h1 {
    margin-bottom: 20px;
}

p {
    margin-bottom: 20px;
    font-size: 18px;
}

a {
    color: #007bff;
}
</style>

