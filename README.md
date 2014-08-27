# Backlog4j

Backlog4j is a Backlog binding library for Java.

Backlog API version 2
 [http://developer.nulab-inc.com/docs/backlog/api/2/](http://developer.nulab-inc.com/docs/backlog/api/2/)

## How to install

### gradle

    'com.nulabinc.backlog4j:backlog4j:2.0.0'

### maven

    <dependency>
      <groupId>com.nulabinc.backlog4j</groupId>
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
    * https://github.com/nulab/backlog4j/javadoc/

## License

MIT License

* http://www.opensource.org/licenses/mit-license.php
