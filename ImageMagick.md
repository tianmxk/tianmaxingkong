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
    convert: error while loading shared libraries: libMagickCore-6.Q16.so.2: cannot open shared object file: No such file or directory
    
    # 解决办法：（系統不知道xxx.so 放在哪個目录下）
    sudo vim /etc/ld.so.conf
    include /usr/local/lib  #（在ld.so.conf文件中加入该行）
    sudo /sbin/ldconfig -v  #（重新载入ld.so.conf文件）

    # 继续执行命令
    convert -version
    
    Version: ImageMagick 6.8.9-10 Q16 i686 2014-11-06 http://www.imagemagick.org
    Copyright: Copyright (C) 1999-2014 ImageMagick Studio LLC
    Features: DPC OpenMP
    Delegates: zlib
    ```
