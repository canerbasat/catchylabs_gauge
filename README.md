# catchylabs_gauge
 
Gauge Maven Projesi için Kurulum Talimatları

Aşağıdaki adımları takip ederek bu projeyi bilgisayarınıza kurabilirsiniz:

1. GEREKSİNİMLER

Kurulumdan önce aşağıdaki yazılımların yüklü olduğundan emin olun:
	•	Java JDK (17 veya daha yüksek bir sürüm)
	•	Maven (3.8 veya üzeri)
	•	Gauge (CLI aracı)
	•	Bir IDE (Örneğin: IntelliJ IDEA, Eclipse, VS Code)

2. JAVA KURULUMU
	1.	Java JDK 17’yi Oracle Java veya OpenJDK üzerinden indirin ve kurun.
	2.	Kurulumdan sonra Java’yı doğrulamak için terminal/komut satırına şu komutu yazın:

java -version

Çıktıda Java 17 veya üzeri sürüm gösterilmelidir.

3. MAVEN KURULUMU
	1.	Maven’ı Apache Maven web sitesinden indirin ve bilgisayarınıza kurun.
	2.	MAVEN_HOME ortam değişkenini ayarlayın ve PATH’e ekleyin.
	3.	Kurulumu doğrulamak için terminal/komut satırına şu komutu yazın:

mvn -version

Maven sürümü başarıyla görüntülenmelidir.

4. GAUGE KURULUMU
	1.	Gauge CLI aracını Gauge web sitesinden indirip kurun.
	2.	Aşağıdaki komutla Gauge’un kurulumunu doğrulayın:

gauge -v

Gauge’un versiyonu ekranda görünmelidir.


5. PROJEYİ KLONLAMA

git clone https://github.com/canerbasat/catchylabs_gauge.git
veya kaynak dosyaları bir zip dosyası olarak indirin ve uygun bir klasöre çıkartın.

	2.	Terminal/komut satırında proje klasörüne gidin:

cd catchylabs_gauge


6. BAĞIMLILIKLARI İNDİRME
	1.	Proje dizininde Maven bağımlılıklarını indirmek için:

mvn clean install



7. TESTLERİ ÇALIŞTIRMA
	1.	Testleri Gauge CLI ile çalıştırmak için:

gauge run specs

veya Maven üzerinden çalıştırmak için:

mvn test

8. PROJEYİ AÇMA (IDE)
	1.	IDE’nizi açın (örneğin IntelliJ IDEA).
	2.	“Open Project” veya “Import Project” seçeneğiyle proje dizinine gidin ve pom.xml dosyasını seçin.
	3.	Maven bağımlılıklarını yenilemek için IDE içinde Maven panelinden Reload yapın.


9. SIK KARŞILAŞILAN SORUNLAR
	•	Gauge CLI Komutları Çalışmıyor: PATH ortam değişkenine Gauge’un yüklendiği dizini eklediğinizden emin olun.
	•	Maven Bağımlılık Hataları: Maven deposunun doğru şekilde ayarlandığından ve internet bağlantınızın olduğundan emin olun.
	•	Otomasyonu Safaride çalıştırmak istediğinizde Safari app giri yapıp otomasyon için izin verdiğinizden emin olun.
