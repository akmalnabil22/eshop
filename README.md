[Link Deployment](https://independent-aubrie-eshop-mal-7318b5e0.koyeb.app/)

[Modul 1](#modul-1)  
[Modul 2](#modul-2)  
[Modul 3](#modul-3)
[Modul 4](#modul-4)

# Modul 1
## Reflection 1
Pada kode saya, saya sudah menerapkan *meaningful names* agar variabel yang ada pada kode mudah dimengerti. 
Saya juga sudah membuat _function_ dengan nama yang mudah dipahami, berukuran kecil, dan hanya melakukan satu hal
spesifik saja. Pada kode yang sudah saya buat, belum ada comments yang dibuat karena menurut saya kode masih belum terlalu rumit. 
Saya juga belum melakukan error handling di semua bagian kode. Selain itu, belum ada validasi input yang dimasukkan. 
Kedepannya mungkin kekurangan-kekurangan ini akan ditambahkan.  

## Reflection 2
1. Menambahkan _unit test_ pada project kita sangat membantu dalam mengecek kebenaran method-method yang telah kita buat. 
Banyaknya unit test yang kita buat tergantung dari berapa banyak method yang kita buat pada project. Untuk memastikan 
unit test yang kita buat saudah cukup atau tidak kita bisa mengecek _code coverage_. 
Code coverage adalah metrik yang mengukur seberapa banyak kode yang sudah dites. 
100% Code coverage bukan berarti kode sudah tidak memiliki bug atau error karena code coverage 
hanya memastikan berapa banyak kode yang sudah dites. Bisa saja terdapat skenario-skenario yang tidak dibuatkan tes yang 
bisa menyebabkan error pada kode.  
2. Jika kita membuat functional test baru dengan setup dan variabel yang sama dengan test sebelumnya, maka akan ada duplicate 
code. Adanya duplicate code akan membuat kode menjadi "kotor". Kode yang kotor akan menyebabkan beberapa masalah. Salah satu 
masalah yang bisa muncul yaitu ketika kita ingin mengubah sesuatu pada kode yang ada duplikatnya, maka kita juga harus mengubah 
semua duplikat kode tersebut. Agar kode bisa menjadi lebih bersih, kita bisa mengimport functional test sebelumnya dan menggunakan 
method yang tersedia. Dengan cara ini, jika terdapat perubahan pada setup dan variabel, maka kita hanya perlu melakukan perubahan sekali saja. 

# Modul 2
1. Unused Import: Pada beberapa class java, dibanding langsung import semua method dari sebuah class, lebih baik jika 
langsung mengimport method yang ingin digunakan.
Unnecessary modifier: Pada interface, method yang ada sudah pasti bersifat public static final sehingga 
tidak perlu menambahkan modifier public sehingga untuk memperbaikinya hanya perlu menghapus modifier public.
2. Kode yang saya buat sudah mengimplementasikan CI/CD. Setiap kali commit dilakukan ke online repository akan dilakukan 
testing dan code scanning untuk memastikan kode sudah berjalan dengan benar yang berarti sudah mengimplementasikan CI. 
Kode juga akan secara otomatis di deploy melalui Platform Koyeb setiap kali ada perubahan pada repository yang berarti sudah 
mengimplementasikan CD.  

# Modul 3  
1. - Implementasi SRP: Saya memindahkan `CarController` dari `ProductController` dan tidak extend `ProductController` karena 
masing-masing Controller memiliki peran masing-masing.
    - Implementasi OCP: Terdapat class `ServiceImpl` yang mengimplement interface `Service`. Jika kita ingin memodifikasi implementasi
   method interface `Service`, kita hanya perlu mengubah implementasi method pada class `ServiceImpl` tanpa perlu mengubah `Service`.
    - Implementasi LSP: Pada class `Controller`, service yang digunakan adalah objek dari `Service`, bukan `ServiceImpl`, yang
   menunjukkan bahwa class `ServiceImpl` bisa digantikan dengan `Service`.
    - Implementasi ISP: Service untuk Car dan Product memiliki interface yang berbeda sesuai dengan kebutuhannya masing-masing.
    - Implementasi DIP: Meskipun terdapat class `ServiceImpl` yang mengimplementasikan interface `Service`, tetapi objek service yang digunakan
   di class `Controller` adalah objek dari interface `Service`.


2. Dengan mengimplementasikan SOLID, kode yang sudah kita buat lebih mudah untuk di maintain. Contohnya pada CarController
dan ProductController. Jika terdapat error pada CarController maka ProductController tidak akan terpengaruh. Lalu, jika kita kita 
ingin mengubah sesuatu pada CarController maka kita akan yakin bahwa perubahan tersebut tidak akan mempengaruhi ProductController. Lalu, dengan
menggunakan objek interface `Service` pada `Controller` kita menerapkan abstraction sehingga client akan lebih fokus terhadap
karakteristik dari service dibanding implementasinya. Jadi, penerapan prinsip SOLID akan sangat membantu pekerjaan kita.


3. Jika kita tidak mengimplementasikan SOLID, akan muncul berbagai masalah. Contohnya jika kita tidak memisahkan `CarController`
dan `ProductController`. Misal kita sedang melakukan testing untuk `ProductController` dan kemudian terjadi error, kita akan kesulitan
menentukan apakah error terjadi di `ProductController` atau `CarController`. Masalah lain muncul jika kita melakukan modifikasi
terhadap `ProductController`. Jika terjadi error pada class `ProductController`, maka proses `CarController` juga akan terganggu. 
Lalu jika kita menggunakan objek `ServiceImpl` pada `Controller`, maka kita harus fokus pada implementasi dari method `Service`
sehingga mengganggu Readability dari kode kita.

## Modul 4
1. Menurut saya, TDD flow cukup menantang ketika dilakukan untuk pertama kali. Saya cukup bingung menentukan test apa saja
   yang perlu ditambahkan. Tetapi ketika diberikan sebuah ketentuan bagaimana program akan berjalan seperti di modul ini, TDD flow
   menjadi cukup bisa dimengerti. Saya bisa membuat test case berdasarkan ketentuan-ketentuan yang diminta. Salah satu tantangan dalam
   TDD menurut saya adalah menentukan unhappy path karena mungkin saja terdapat edge case yang terlewatkan yang mungkin bisa saja
   menyebabkan program error.


2. Saya sudah menerapkan beberapa FIRST principle. Test case yang saya buat berjalan dengan cepat, repeatable, dan self-validating. Tetapi,
   ada test case yang masih bergantung pada test case lain. Lalu, terdapat beberapa unhappy path yang belum dicover pada test case
   yang saya buat.