Çalıştırma:
1. maven dependency'lerini görebilmesi için intellij terminalinden "mvn clean install" komutunu çalıştırınız.
2. Localde "cimri" isimli database kurunuz. "jdbc.properties" dosyasında bu dbnin bilgileri yer almaktadır.
3. /conf/script/ altındaki db.sh komut dosyasını çalıştırınız bu gerekli tabloları oluşturduğunuz cimri db si üzerinde oluşturacaktır.(terminalden "mysql.server start" diyiniz.)
4. xml dosyalarındaki datayı db'ye aktarmak için öncelikle XMLFileReader.java class'ını çalıştırınız.
5. Uygulamayı çalıştırmak için Application.java class'ını çalıştırınız ve browser'dan localhost:8080 yazınız.


Kullanılan programlar:
1. Mysql db connection'ı için SequelPro kullanılmıştır.
2. IDE olarak Intellij kullanılmıştır.
3. Java 8,Spring Framework, Maven kullanılmıştır ve db için MySQL kullanılmıştır.
