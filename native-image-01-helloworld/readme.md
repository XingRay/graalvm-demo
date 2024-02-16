## native-image 生成原生镜像流程：

### 1. 编译

```shell
javac HelloWorld.java
```

### 2. 转化为 native image 
```shell
native-image HelloWorld
```

### 3. 执行
```shell
./HelloWorld.exe
```
