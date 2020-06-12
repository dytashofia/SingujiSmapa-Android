<?php
define('HOST', 'localhost');
define('Username', 'root');
define('Password', '');
define('Database', 'db_singuji');

$con=mysqli_connect("HOST", "Username", "Password", "Database");
if (mysqli_connect_errno()){
	echo "Gagal melakukan koneksi ke MySQL: " . mysqli_connect_error();
}

$username = $_POST["username_siswa"];
$password = $_POST["password_siswa"];

$query_sql = "SELECT*FROM tb_siswa where username_siswa = $username AND password_siswa = $password";

$data[] = mysqli_fetch_assoc($query_sql));
$jsonfile = json_encode($data, JSON_PRETTY_PRINT);

echo ($jsonfile);

?>