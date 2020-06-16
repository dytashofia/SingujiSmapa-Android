<?php

if($SERVER['REQUEST_METHOD'] == 'POST' )
{
    $username = $_POST["username_siswa"];
    $password = $_POST["password_siswa"];

    require_once "koneksi.php";

    $sqlSelect = "SELECT*FROM tb_siswa where username_siswa = '$username' AND password_siswa = '$password'";

    $response = mysqli_query($con, $sqlSelect);

    $result = array();
    $result['login_siswa'] = array();

    if(mysqli_num_rows($response) === 1)
    {
        $row = mysqli_fetc_assoc($response);

        if(password_verify($password, $row['password_siswa']))
        {
            $index = array();
            $index['username_siswa'] = $row['username_siswa'];
            $index['password_siswa'] = $row['password_siswa'];

            array_push($result['login'], $index);

            $result['Success'] = "1";
            $result['message'] = "success";
            echo json_encode($con);

            mysqli_close($con);

        }

    } else
    {
         $result['Success'] = "0";
         $result['message'] = "Error";
         echo json_encode($result);
    }

}


?>