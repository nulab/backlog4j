# Backlog4j [![Build Status](https://travis-ci.org/nulab/backlog4j.svg?branch=master)](https://travis-ci.org/nulab/backlog4j)

Backlog4j is a Backlog binding library for Java.

![Backlog icon](https://raw.githubusercontent.com/nulab/backlog4j/master/icon.png)

* Backlog 
    * [http://backlog.jp](http://backlog.jp)
    * [http://backlogtool.com](http:///backlogtool.com)

* Backlog API version 2
    * [http://developer.nulab-inc.com/docs/backlog/api/2/](http://developer.nulab-inc.com/docs/backlog/api/2/)

![Nulab developer icon](https://raw.githubusercontent.com/nulab/backlog4j/master/dev_icon.png)

## How to install

### gradle

    'com.nulab-inc:backlog4j:2.0.0'

### maven

    <dependency>
      <groupId>com.nulab-inc</groupId>
      <artifactId>backlog4j</artifactId>
      <version>2.0.0</version>
    </dependency>

## How to use
Get the BacklogClient with your space id and your api key.
    
    BacklogConfigure configure = new BacklogDefaultConfigure("yourSpaceId").apiKey("yourApiKey");
                        
    BacklogClient backlog = new BacklogClientFactory(configure).newClient();


Then call Backlog API method. Enjoy Backlog API!

    Project project = backlog.getProject("PROJECT-KEY");



## Documents

* javadoc
    * http://nulab.github.io/backlog4j/javadoc/

## License

MIT License

* http://www.opensource.org/licenses/mit-license.php
