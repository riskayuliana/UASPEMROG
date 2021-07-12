<?php
require_once 'db_connection.php';
header("Content-Type: application/json; charset=UTF-8");

$username = $_POST['username'];
$password = $_POST['password'];
$namalengkap = $_POST['nama_lengkap'];
$email = $_POST['email'];
$alamat = $_POST['alamat'];
$jeniskelamin = $_POST['jenis_kelamin'];

$query = "INSERT INTO users (`username`, `password`, `nama_lengkap`,  `email`, `alamat`, `jenis_kelamin`) 
VALUES ('$username', '$password', '$namalengkap', '$email', '$alamat', '$jeniskelamin')";

$execute = mysqli_query($dbConnection, $query);
$response = [];

if ($execute) {
  $response['status'] = 'success';
  $response['message'] = 'Berhasil mendaftar account';
} else {
  $response['status'] = 'failed';
  $response['message'] = 'Gagal mendaftar account';
}
$json = json_encode($response, JSON_PRETTY_PRINT);
echo $json;
