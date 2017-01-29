<head>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<?php
	include("../connect.php");
	$current_hospital=$_REQUEST['current_hospital'];
?>
  <table class="table">
    <thead>
      <tr>
        <th>Patient id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Funds Required</th>
      </tr>
    </thead>
    <tbody>
<?php
	$res=mysqli_query($con,"SELECT * from casuality WHERE hospital='$current_hospital'");
     while($row=mysqli_fetch_array($res))
		{
			
      echo '<tr>';
        echo "<td>".$row['sno']."</td>";
        echo "<td>".$row['name']."</td>";
        echo "<td>".$row['age']."</td>";
        echo "<td>".$row['fund']."</td>";
      echo '</tr>';
 		}
?>
    </tbody>
  </table>

