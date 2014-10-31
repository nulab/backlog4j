# Backlog4j [![Build Status](https://travis-ci.org/nulab/backlog4j.svg?branch=master)](https://travis-ci.org/nulab/backlog4j)

Backlog4j is a Backlog binding library for Java.
(英語の下に日本文が記載されています)

![Backlog icon](https://raw.githubusercontent.com/nulab/backlog4j/master/icon.png)

* Backlog 
    * [http://backlog.jp](http://backlog.jp)
    * [http://backlogtool.com](http:///backlogtool.com)

* Backlog API version 2
    * [http://developer.nulab-inc.com/docs/backlog/api/2/](http://developer.nulab-inc.com/docs/backlog/api/2/)

![Nulab developer icon](https://raw.githubusercontent.com/nulab/backlog4j/master/dev_icon.png)

## Update
* 2014/10/31 2.0.6 released
* 2014/10/29 2.0.5 released
* 2014/10/18 2.0.4 released
https://github.com/nulab/backlog4j/releases

## Install

### gradle

    'com.nulab-inc:backlog4j:2.0.6'

### maven

    <dependency>
      <groupId>com.nulab-inc</groupId>
      <artifactId>backlog4j</artifactId>
      <version>2.0.6</version>
    </dependency>

## How to use
Make BacklogConfigure with your space id and your api key.
    
    # If your space is in backlogtool.com
    BacklogConfigure configure = new BacklogToolConfigure("yourSpaceId").apiKey("yourApiKey");

    # If your space is in backlog.jp
    BacklogConfigure configure = new BacklogJpConfigure("yourSpaceId").apiKey("yourApiKey");
                            
And get the BacklogClient.
                            
    BacklogClient backlog = new BacklogClientFactory(configure).newClient();


Then call Backlog API method. Enjoy Backlog API!

    Project project = backlog.getProject("PROJECT-KEY");



## Documents

* javadoc
    * http://nulab.github.io/backlog4j/javadoc/

## License

MIT License

* http://www.opensource.org/licenses/mit-license.php

## Requires
* Java 1.6


# Backlog4j とは
Backlog4j は Backlog API 簡単にアクセスするためのJavaクライアントライブラリです。

## インストール

### gradle を利用する場合

    'com.nulab-inc:backlog4j:2.0.6'

### maven を利用する場合

    <dependency>
      <groupId>com.nulab-inc</groupId>
      <artifactId>backlog4j</artifactId>
      <version>2.0.6</version>
    </dependency>

## 使い方

基本的な使い方は以下の 2 ステップとなります。

* BacklogConfigure を設定して BacklogClient オブジェクトを生成
* Backlog API に従ったメソッド呼び出し

以下の例では スペースIDとAPIキーを用いて BacklogConfigure を設定しています。

    # あなたのスペースが backlog.jp 内にある場合 
    BacklogConfigure configure = new BacklogJpConfigure("yourSpaceId").apiKey("yourApiKey");
    
    # あなたのスペースが backlogtool.com 内にある場合
    BacklogConfigure configure = new BacklogToolConfigure("yourSpaceId").apiKey("yourApiKey");

続いて BacklogClient を生成します。
                            
    BacklogClient backlog = new BacklogClientFactory(configure).newClient();

そして、取得したいプロジェクトのキーを指定し、プロジェクト情報をAPI経由で取得します。

    Project project = backlog.getProject("PROJECT-KEY");
    