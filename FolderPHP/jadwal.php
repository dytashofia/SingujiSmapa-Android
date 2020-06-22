<?php
$con=mysqli_connect("localhost","root","","db_singuji");

if (mysqli_connect_errno()){
	echo "Gagal melakukan koneksi ke MySQL: " . mysqli_connect_error();
}

$query=mysqli_query($con,"SELECT tb_mapel.mata_pelajaran,tb_guru.status,tb_guru.nama_guru,tb_tipe_ujian.tipe_ujian,tb_ujian.waktu_mengerjakan,tb_ujian.tgl_mulai,tb_ujian.jumlah_soal,tb_ujian.terlambat FROM `tb_ujian`,`tb_mapel`,`tb_tipe_ujian`,`tb_guru`
WHERE tb_ujian.NIP=tb_guru.NIP AND tb_ujian.id_mapel=tb_mapel.id_mapel AND tb_ujian.id_tipe=tb_tipe_ujian.id_tipe");
$json=array();
while ($data=mysqli_fetch_assoc($query)) {
    $json[]=$data;
} 
echo json_encode($json);
?>