<?php

define('HOST', 'localhost');
define('Username', 'root');
define('Password', '');
define('Database', 'db_singuji');

$con=mysqli_connect("HOST", "Username", "Password", "Database");
if (mysqli_connect_errno()){
	echo "Gagal Koneksi ke Database: " . mysqli_connect_error();
}

?>