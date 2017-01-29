<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="lightbox2-master/dist/css/lightbox.min.css">
<style type="text/css">
	*{
		padding: 0.5%;
		margin: 0.5%;
	}
	body{
		background-color: #eee;
	}
	#main-logo{
		position: fixed;
		top: 0.5%;
		right: 0.5%;
		width: 20%;
		height: 12%;
		}
	#main-view{
		position: fixed;
		top: 0.5%;
		left: 0.5%;
		width: 76.5%;
		height: 97%;
		background-color: #2c3e50;
		border-radius: 2%;
	}
	#image-view{
		position: fixed;
		bottom: 0.5%;
		left: 0.5%;
		width: 76.5%;
		height: 21%;
				border-radius: 2%;


		background-color: #2c3e50;
	}
	#village-search{
		position: fixed;
		bottom: -2%;
		right: -1%;
		width: 22%;
		height: 85%;
				border-radius: 2%;

		background-color: #2c3e50;
		overflow: scroll;
	}
	.alert{
		text-align: center;
		height: 10%;
	}
	/* enable absolute positioning */
	.inner-addon { 
    position: relative; 
	}

	/* style icon */
	.inner-addon .glyphicon {
  position: absolute;
  padding: 10px;
  pointer-events: none;
	}

	/* align icon */
	.left-addon .glyphicon  { left:  0px;}
	.right-addon .glyphicon { right: 0px;}

	/* add padding  */
	.left-addon input  { padding-left:  30px; }
	.right-addon input { padding-right: 30px; }
        @font-face{
            font-family: "KINKY";
            src:url('KINKY.ttf') format('truetype');
        }

        h1{
            text-align: center;
            font:60px "KINKY";
        }
</style>
</head>

<body style="overflow:hidden">
<div id="main-logo"><h1>Hospital List</h1></div>
<div id="main-view"></div>


<div id="village-search">
		<div class="inner-addon left-addon">
    	<i class="glyphicon glyphicon-search"></i>
    	<input type="text" class="form-control" placeholder="Hospital Search" onKeyUp="getStatus(this.value)"/>
		</div>
		<hr>
	<div id="village-list-view">
	<?php
		include '../connect.php';
		$result=mysqli_query($con,"SELECT distinct hospital FROM casuality WHERE 1");
		while($row=mysqli_fetch_array($result))
		{
			echo '<div class="alert alert-info" id="'.$row['hospital'].'">'.$row['hospital'].'</div>';
		}
	?>
	</div>
</div>
<script src="lightbox2-master\dist\js\lightbox-plus-jquery.min.js"></script>
<script>

$(document).ready(function() {
    $(".alert").click(function(){
    	var that=$(this);
    	$("#main-view").html('<iframe width=98% height=100% scrolling=no src="output.php?current_hospital='+that.attr("id")+'"></iframe>');
    });
});

function getStatus(value){
	$.post( "getStatus.php",{partialState:value}, function( data ) {
		  $( "#village-list-view" ).html( data );
		});

}
</script>
</body>