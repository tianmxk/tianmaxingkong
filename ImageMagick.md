ImageMagick是用C语言开发图片处理程序。可以对图片进行改变大小、旋转、锐化、减色或增加特效等操作。对图片的操作，即可以通过命令行进行，也可以用C/C++、Perl、Java、PHP、Python或Ruby编程来完成。

## Ubuntu系统ImageMagick安装 
### 1.下载[ImageMagick](http://imagemagick.org/script/download.php)
### 2.解压安装
```shell
tar zxvf ImageMagick-6.8.9-10.tar.gz
cd ImageMagick-6.8.9-10/
./configure
sudo make
sudo make install
```
### 3.判断ImageMagick是否安装成功
```shell
convert -version
# convert: error while loading shared libraries: libMagickCore-6.Q16.so.2: 
# cannot open shared object file: No such file or directory
  
# 解决办法：（系統不知道xxx.so 放在哪個目录下）
sudo vim /etc/ld.so.conf
include /usr/local/lib  #（在ld.so.conf文件中加入该行）
sudo /sbin/ldconfig -v  #（重新载入ld.so.conf文件）

# 继续执行命令
convert -version
# Version: ImageMagick 6.8.9-10 Q16 i686 2014-11-06 http://www.imagemagick.org
# Copyright: Copyright (C) 1999-2014 ImageMagick Studio LLC
# Features: DPC OpenMP
# Delegates: zlib
```
### 4.图片格式转换
```shell
convert tmp.jpg tmp.png
# convert: no decode delegate for this image format `JPEG' @ error/constitute.c/ReadImage/501.
# convert: no images defined `tmp.png' @ error/convert.c/ConvertImageCommand/3210.

# 解决问题：（安装ImageMagick支持库）
# 安装[libjpeg](http://www.ijg.org/) (支持JPEG格式)
#    wget http://www.ijg.org/files/jpegsrc.v9a.tar.gz
#    tar zxvf jpegsrc.v9a.tar.gz
#    cd jpeg-9a/
#    ./configure --enable-shared
#    sudo make && sudo make install
# 安装[libpng](http://www.libpng.org/) (支持png格式) [下载](http://www.libpng.org/pub/png/libpng.html）
#    tar zxvf libpng-1.6.14.tar.gz
#    cd libpng-1.6.14/
#    ./configure
#    sudo make && sudo make install

# 继续执行命令
convert tmp.jpg tmp.png
# convert: no decode delegate for this image format `JPEG' @ error/constitute.c/ReadImage/501.
# convert: no images defined `tmp.png' @ error/convert.c/ConvertImageCommand/3210.

# 发现还是报错，需要重新执行第二步（重新安装ImageMagick）
convert tmp.jpg tmp.png
# convert: error while loading shared libraries: libjpeg.so.9: 
# cannot open shared object file: No such file or directory

# 解决问题：
sudo ranlib /usr/local/lib/libjpeg.a
sudo ldconfig /usr/local/lib

# 继续执行命令
convert tmp.jpg tmp.png

# Done.
```
### 5.将PDF转换PNG
```shell
# TODO 清晰度设置
convert tmp.pdf -density 300 tmp.png
```

### 6.缩放图片
```shell
# 保持高宽比
convert tmp.jpg -resize 64x64 resize_tmp.jpg
# 不保持高宽比
convert tmp.jpg -resize 64x64\! resize_tmp.jpg
# 只缩小大图
convert tmp.jpg -resize 64x64\> resize_tmp.jpg
# 只放大小图
convert tmp.jpg -resize 64x64\< resize_tmp.jpg
# 按比例缩放
convert tmp.jpg -resize 50% resize_tmp.jpg
```

## 参考资料：
[ImageMagicK 常用命令](http://hahack.com/wiki/tools-imagemagick.html)
[ImageMagick 命令行下图像处理的利器](http://segmentfault.com/a/1190000000442060)
