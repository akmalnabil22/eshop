[Link Deployment](https://independent-aubrie-eshop-mal-7318b5e0.koyeb.app/)

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