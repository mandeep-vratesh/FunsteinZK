
<?php

$alert=$_POST['alert'];
$type=$_POST['type'];
include '../connect.php';
if(mysqli_query($con,"INSERT INTO alert(`alert`, `type`,`a_date`, `a_time`) VALUES('$alert','$type',CURDATE(),CURTIME())"))
	echo "done";

else
	echo mysqli_error($con);
?>
