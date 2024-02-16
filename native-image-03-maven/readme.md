## native-image 生成原生镜像流程：

使用 native-maven-plugin 插件一键编译

### 1. 编译

```shell
mvn -Pnative clean package
```

### 2. 运行

```shell
./target/hello.exe
```
