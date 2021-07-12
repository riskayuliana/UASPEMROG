<?php
require_once 'db_connection.php';
header("Content-Type: application/json; charset=UTF-8");

$namabarang = $_POST['nama_barang'];
$hargabelibarang = $_POST['hargabeli_barang'];
$hargajualbarang = $_POST['hargajual_barang'];
$jumlah = $_POST['jumlah'];
$entryby = $_POST['entry_by'];

$query = "INSERT INTO entry_barang (`nama_barang`, `hargabeli_barang`,  `hargajual_barang`, `jumlah`, `entry_by`) 
VALUES ('$namabarang', '$hargabelibarang', '$hargajualbarang', '$jumlah', '$entryby')";

$execute = mysqli_query($dbConnection, $query);
$response = [];

if ($execute) {
  $response['status'] = 'Success';
  $response['message'] = 'Berhasil';
} else {
  $response['status'] = 'Failed';
  $response['message'] = 'Gagal';
}
$json = json_encode($response, JSON_PRETTY_PRINT);
echo $json;
