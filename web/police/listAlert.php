<head>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<style type="text/css">
	div.alerts{
		margin-left: 1%;
		margin-right: 1%;
		}
		</style>
</head>
<?php
include "../connect.php";

$sql="SELECT * FROM alert WHERE 1 order by `ano` desc";
$result=mysqli_query($con,$sql);
echo "<center><h4>ALERTS</h4></center>";
while($row=mysqli_fetch_array($result))
{
	if($row['type']=="caution")
			echo'<div class="alert alert-danger"><strong>('.$row['a_date'].' '.$row['a_time'].'):</strong><br> '.$row['alert'].'</div>';
	elseif($row['type']=="information")
			echo'<div class="alert alert-info"><strong>('.$row['a_date'].' '.$row['a_time'].'):</strong><br> '.$row['alert'].'</div>';
}

?>
