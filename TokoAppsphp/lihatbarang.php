<?php
require_once 'db_connection.php';
header("Content-Type: application/json; charset=UTF-8");

$query = "SELECT * FROM entry_barang";
$execute = mysqli_query($dbConnection, $query);
$cek = mysqli_affected_rows($dbConnection);

if ($cek>0) {
  $response['status'] = 'Success';
  $response['message'] = 'Data ditemukan';
  $response['data'] = array();
      while ($row = mysqli_fetch_object($execute)) {
        $F['id_barang'] = $row->id_barang;
        $F['nama_barang'] = $row->nama_barang;
        $F['hargabeli_barang'] = $row->hargabeli_barang;
        $F['hargajual_barang'] = $row->hargajual_barang;
        $F['jumlah'] = $row->jumlah;
        $F['entry_by'] = $row->entry_by;

        array_push($response['data'],$F);
      }
}
else {
      $response['status']='Failed';
      $response['message'] = 'Data tidak ditemukan';
}
$json = json_encode($response, JSON_PRETTY_PRINT);
echo $json;
