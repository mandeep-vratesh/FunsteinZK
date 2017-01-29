<?php
	include("../connect.php");
	$partialStatus=$_POST['partialState'];


$status=mysqli_query($con,"SELECT distinct hospital from casuality WHERE hospital LIKE '%$partialStatus%'");
	if($partialStatus=="")
		{
			$result=mysqli_query($con,"SELECT distinct hospital FROM casuality WHERE 1");
			while($row=mysqli_fetch_array($result))
			{
				echo '<div class="alert alert-info" id="'.$row['hospital'].'">'.$row['hospital'].'</div>';
			}
		}
	else if(mysqli_num_rows($status)==0)
		{
			echo '<div style="border-radius:3px;background-color:#aaa;">No such hospital name found</div>';
		}
	else	
	{
		while($row=mysqli_fetch_array($status))
		{
			echo '<div class="alert alert-info" id="'.$row['hospital'].'">'.$row['hospital'].'</div>';
		}
	}
?>
<script>
$(document).ready(function() {
    $(".alert").click(function(){
    	var that=$(this);
    	$("#main-view").html('<iframe width=98% height=100% scrolling=no src="output.php?current_hospital='+that.attr("id")+'"></iframe>');
    });
});
</script>
