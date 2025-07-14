# Backlog4j ![Build Status](https://github.com/nulab/backlog4j/actions/workflows/build.yml/badge.svg?branch=master)

Backlog4j is a Backlog binding library for Java.
(英語の下に日本文が記載されています)

<img src="https://raw.githubusercontent.com/nulab/backlog4j/master/Backlog_logo.png" width='200'>


* Backlog
    * [https://backlog.com/](https://backlog.com/)
    * [https://backlog.com/ja/](https://backlog.com/ja/)

* Backlog API version 2
    * [https://developer.nulab.com/docs/backlog/#](https://developer.nulab.com/docs/backlog/#)
    * [https://developer.nulab.com/ja/docs/backlog/#](https://developer.nulab.com/ja/docs/backlog/#)


## Updates
* 2025/07/14 2.7.0 released
* 2023/11/20 2.6.0 released
* 2023/07/27 2.5.3 released
* 2022/09/15 2.5.2 released
* 2022/08/24 2.5.1 released
* 2022/04/27 2.5.0 released
* 2021/06/10 2.4.4 released

https://github.com/nulab/backlog4j/releases

## How to Install

### gradle

    'com.nulab-inc:backlog4j:2.7.0'

### maven

    <dependency>
      <groupId>com.nulab-inc</groupId>
      <artifactId>backlog4j</artifactId>
      <version>2.7.0</version>
    </dependency>

## How to use
Make BacklogConfigure with your space id and your api key.

    # If your space is in backlog.com
    BacklogConfigure configure = new BacklogComConfigure("yourSpaceId").apiKey("yourApiKey");

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
* Java 11


# Backlog4j とは
Backlog4j は Backlog API (https://developer.nulab.com/ja/docs/backlog/#) に簡単にアクセスするためのJavaクライアントライブラリです。

## インストール

### gradle を利用する場合

    'com.nulab-inc:backlog4j:2.7.0'

### maven を利用する場合

    <dependency>
      <groupId>com.nulab-inc</groupId>
      <artifactId>backlog4j</artifactId>
      <version>2.7.0</version>
    </dependency>

## 使い方

基本的な使い方は以下の 2 ステップとなります。

* BacklogConfigure を設定して BacklogClient オブジェクトを生成
* Backlog API に従ったメソッド呼び出し

以下の例では スペースIDとAPIキーを用いて BacklogConfigure を設定しています。

    # あなたのスペースが backlog.com 内にある場合
    BacklogConfigure configure = new BacklogComConfigure("yourSpaceId").apiKey("yourApiKey");

    # あなたのスペースが backlog.jp 内にある場合
    BacklogConfigure configure = new BacklogJpConfigure("yourSpaceId").apiKey("yourApiKey");

    # あなたのスペースが backlogtool.com 内にある場合
    BacklogConfigure configure = new BacklogToolConfigure("yourSpaceId").apiKey("yourApiKey");

続いて BacklogClient を生成します。

    BacklogClient backlog = new BacklogClientFactory(configure).newClient();

そして、取得したいプロジェクトのキーを指定し、プロジェクト情報をAPI経由で取得します。

    Project project = backlog.getProject("PROJECT-KEY");


## Android でご使用の場合
proguard-rules に以下を追記して難読化の対象外とすることを推奨します。

    #Backlog4j
    -keep public class com.nulabinc.backlog4j.** {*;}

    #Jackson(Backlog4j is using jackson)
    -keepattributes *Annotation*,EnclosingMethod, Signature, InnerClasses
    -keepnames class com.fasterxml.jackson.** { *; }
    -dontwarn com.fasterxml.jackson.databind.**
