
 **环境:Fedola-24、jdk-1.8、gradle-2.14.1、maven-3.3**
 docker环境:
    安装mysql:
    docker pull mysql
         docker run -it --name=mysql -p 3306:3306 -v /home/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root mysql
    安装mongo:
    docker pull mongo
         docker run -it --name=mongo -p 27017:27017 -v /home/mongo/data:/data/db mongo
 整合框架:spring boot、jpa(hibernate)、springMvc(数据校验),guava(限流器)
 安装 redis:
     docker pull redis
    docker run -it --name=redis -p 6379:6379 -v /home/redis/data:/data redis
 
 **运行步骤**
 1. gradle build -xtest 打jar包
 2. 项目下/build/libs 下jar包 java -jar community.jar & 即可运行