## native-image 生成原生镜像流程

使用 native-maven-plugin 插件一键编译, 并且测试java的动态代理功能是否可以正常使用

### 1. 编译

```shell
mvn -Pnative clean package
```

### 2. 运行

```shell
./target/proxy-app.exe
```
