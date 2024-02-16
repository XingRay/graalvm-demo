## native-image 生成原生镜像流程：

### 1. maven 打包

```bash
mvn -Pnative clean package
```

### 2. 修改镜像为widows程序
默认打包的程序是Console程序, 启动后会自动打开一个Console "黑窗口" , 通过下面的指令进行编辑后转化为windows程序, 直接启动窗口程序.
```bash
editbin /SUBSYSTEM:WINDOWS target\launcher.exe
```

### 3. 将镜像复制到指定文件夹，该文件夹已经提供了运行所需要的基本的动态链接库，如果更新了代码需要添加依赖库

```bash
copy target\launcher.exe native-image\launcher.exe
```
此时会无法运行, 需要运行环境需要的各种lib文件等, 将 javafx-graphics-21.0.2-win.jar 解压到 launcher.exe 同目录即可. 只需要 javafx-graphics-21.0.2-win.jar 中
的一级目录下的文件, 其余目录可以删除.

实测: 至少保留 glass.dll javafx_font.dll prism_d3d.dll 这三个文件就可以运行最简单的带ui的可执行文件

### 4. 通过指令运行或者双击

```bash
native-image\launcher.exe
```


### all in one
```bash
mvn -Pnative clean package
EDITBIN /SUBSYSTEM:WINDOWS target\launcher.exe
copy target\launcher.exe native-image\launcher.exe
native-image\launcher.exe
```