<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Live Alerts</title>
      <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
      <link rel="stylesheet" href="css/style-header.css">
      <link rel="stylesheet" href="css/style-button.css">
      <link rel="stylesheet" href="css/style-navi.css">

      <style>

        .alert-danger, .alert-info{
          border: 1px solid black;
          border-radius: 7px;
          padding: 5px;
          font-size: 15px;
          font-weight: bold;
          margin: 10px auto;
          box-shadow: 5px 5px 5px #aaa;
        }

        .mess{
          font-size: 20px;
          font-weight:  
        }

        .alert-danger{
          background-color: #ef9a9a;
        }

        .alert-info{
          background-color: #81D4FA;
        }
      
      </style>

  </head>

  <body>
    <header class="main-header">
      <h1>Alerts</h1>

      
      
    </header>
    <div id="navi">
      <nav>
        <a href="http://www.antiterror.pe.hu">Home<i class="fa fa-home" style="margin-left: 10%;"></i></a>
        <a href="Terrorist Attacks.html">Terrorist Attacks</a>
        <a href="http://www.antiterror.pe.hu/dangerzones/dangerzone.html">Live Danger Zones</a>
        <a href="#" class="active">Live Alert</a>
        <a href="Safety Guidlines.html">Safety Guidlines</a>
        <a href="Proactive Preparations.html">Proactive Preparations</a>
        <a href="Do's And Dont's.html">Do's And Dont's</a>
        <a href="Self Protection.html">Self Protection </a>
        <a href="Survival Guidlines.html">Survival Guidlines</a>
        <a href="Emergency Nos.html">Emergency Nos</a>
        <a href="FAQs.html">FAQs</a>
        <a href="Suspicious.html">Report Suspicious Activity</a>
      </nav>
    </div>
    <main class="content">
      
      <?php
      include "../connect.php";

      $sql="SELECT * FROM alert WHERE 1 order by `ano` desc";
      $result=mysqli_query($con,$sql);
      
      while($row=mysqli_fetch_array($result))
      {
        if($row['type']=="caution")
          echo'<div class="alert-danger"> <p> Date: '.$row['a_date'].'    Time: '.$row['a_time'].'</p><p class="mess">'.$row['alert'].'</div>';
        elseif($row['type']=="information")
          echo'<div class="alert-info"> <p> Date: '.$row['a_date'].'    Time: '.$row['a_time'].'</p><p class="mess">'.$row['alert'].'</div>';
      }

      ?>

    </main>
    
    <script src="js/index-header.js"></script>
    
  </body>
</html>
