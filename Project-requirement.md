# Reverse Proxy #
This challenge aims to develop a highly available and scalable reverse-proxy service for San Francisco’s public 
transportation using the NextBus feed.

##
NextBus provides a real-time data feed that exposes bus and train service information to the public. The instructions for using the real-time data feed are here:
http://www.nextbus.com/xmlFeedDocs/NextBusXMLFeed.pdf

1.In addition to proxying queries to NextBus, the application should also expose an endpoint for exposing statistics.
        -Slow_requests - List the endpoints which had response time higher a certain threshold along with the time taken.
        -Queries - List all the endpoints queried by the user along with the number of requests for each.

```
GET /api/v1/stats

{

 "slow_requests": {

   "/foo/bar": "9.8s",

   "/bar/foo": "5.3s"

 },

 "queries": {

   "/foo/bar": "20",

   "/bar/foo/": "7"

 }

}
```
##


##
Caching
##
```
Add a layer of caching to the reverse proxy with a configurable timeout. 
The NextBus feed service is sensitive to traffic and doesn’t hesitate to block if too many requests are being sent. 
Caching by your application would make the responses faster and less prone to timeouts or blocks.
```

##
Storage
##
```
Use a common datastore to ensure that all instances of the proxy expose the same statistics about the application.
For example, all application instances could write the stats to mysql (or a db of your choice), running as container, ensuring that each instance exposes the same statistics.
```



