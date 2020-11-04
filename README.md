# bulletin
1. Build application using maven from the project diretory "mvn clean install" to check 
2.Run the application via jar(bulletin-0.0.1-SNAPSHOT.jar) or  directly @SpringBootApplication annotated java class
3.I use 8080 as default port, if you want please change it through application.properties 
4.http://localhost:8080/swagger-ui.html#/ for the API documentation 
5.http://localhost:8080/weather/forecast?city={name of the city}
6. Hope Dockerfile will be fine, because I have some issues with desktop docker, so please build the image, 
using the following commands under the project directory(hope docker is running)
Build docker image  =>docker build -f Dockerfile -t weatherAPI .
Run the image => docker run -p 8080:8080 weatherAPI
use the url from point no 4, to confirm docker instance running
7.sample output for the city milan
[
{
date: "2020-11-05",
dayTemperature: 16.71,
nightTemperature: 14.12,
humidity: 73.38
},
{
date: "2020-11-06",
dayTemperature: 15.24,
nightTemperature: 13.2,
humidity: 57.88
},
{
date: "2020-11-07",
dayTemperature: 14.72,
nightTemperature: 12.06,
humidity: 61.25
}
]
