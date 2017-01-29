<?php
	$con=mysqli_connect('mysql.hostinger.in','u621445275_nks','niranjan');
	if($con)
		echo "";
	else 
		echo "connection no done";
	
	if(mysqli_select_db($con,"u621445275_terro"))
		echo "";
	else
		echo "db no seleced";
?>