<p align="center">
	<strong> 一个基于springboot的CodePaste后端平台 </strong>
</p>

<p align="center">
	<a>
	    <img src="https://img.shields.io/badge/build-passing-brightgreen">
	</a>
	<a>
	    <img src="https://img.shields.io/badge/JDK-1.7%2B-green">
	</a>
	<a href="http://www.apache.org/licenses/LICENSE-2.0.html" target="_blank">
            <img src="http://img.shields.io/:license-apache-brightgreen.svg" >
        </a>
	<a>	
	    <img src="https://img.shields.io/badge/license-apache-green">
	</a>
	<a>
            <img src="https://img.shields.io/badge/springBoot-1.5.x__2.x.x-green.svg" >
   	</a>
	
</p>


# 1、前言

这是一个基于springboot简易文件传输的网站。该网站搭建了一个专门用于传输信息的平台，同时该网站界面美观、操作简易。在这里，每个用户都可以设置属于他自己的文件，并设置相应的秘钥分享给他人。

# 2、产品整体框架与需求

## 2.1产品信息结构图

![image](https://user-images.githubusercontent.com/61532079/136649626-c0f02745-d7a8-49f4-8e80-fe02db181c98.png)

 

 <details>
<summary> 产品功能需求表 </summary>

## 2.2 产品功能需求表

| **功能分类** | **功能说明**                                                 |                                                   |                                                              |
| ------------ | ------------------------------------------------------------ | ------------------------------------------------- | ------------------------------------------------------------ |
| 主界面       | 个人信息                                                     | 1、可以设置自己的个人信息  2、可以设置自己的头像  |                                                              |
| 全部文件     | 1、可以查看已下载的文件                                      |                                                   |                                                              |
| 搜索         | 1、通过搜索可以查找自己文件列表里相应的文件                  |                                                   |                                                              |
| 回收站       | 1、可以查看已被加入回收站的文件并可在在其中永久删除不要的文件 |                                                   |                                                              |
| 下载、上传   | 1、可以下载或者上传用户所需求的文件                          |                                                   |                                                              |
| 文件板块     | 文件详情                                                     | 密钥                                              | 1、可设置该上传文件的密钥方便定向传输  2、可通过密钥查询所需文件 |
| 用户名       | 1、文件发送者的用户名                                        |                                                   |                                                              |
| 有效期       | 1、可设置文件在云端的有效期，到期云端自动销毁                |                                                   |                                                              |
| 个人板块     | 用户信息                                                     | 头像                                              | 1、显示头像；  2、可更改头像。                               |
| 昵称         | 1、显示昵称；  2、可更改昵称。                               |                                                   |                                                              |
| 登录         | 注册                                                         | 1、手机号注册或者邮箱注册。                       |                                                              |
| 登录         | 1、账号密码登录；  2、手机验证码登录；  3、邮箱登录；        |                                                   |                                                              |
| 记录备份     | 下载、上传记录                                               | 1、可在其中查询下载或者上传过的文件的相关简要信息 |                                                              |
| 产品服务板块 | 数据传输                                                     | 1、可指定文件传输通道                             |                                                              |
| 数据安全     | 1、可进一步加密文件，保护用户信息安全                        |                                                   |                                                              |
</details>
