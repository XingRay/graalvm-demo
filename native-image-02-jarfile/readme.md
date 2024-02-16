## native-image 生成原生镜像流程：

### 1. 编译

```shell
mvn clean package
```

### 2. 转化为 native image
```shell
native-image -jar .\target\native-image-02-jarfile-1.0.0.jar
```

### 3. 执行
```shell
.\native-image-02-jarfile-1.0.0.exe
```
