<?php

if (isset($_POST['Std_ID'])) {
  $conn = mysqli_connect("localhost","root","","Attendance");
if(!$conn){
    die("Connection error: " . mysqli_connect_error()); 
}
$user=4;
$sq="SELECT * FROM `workload` where LectureID=$user";
$current=date('Y-m-d') ."\n";
$query=mysqli_query($conn,$sq);
while ( $row=mysqli_fetch_array($query)) {
        $start=$row['Start'];
        $snd=$row['End'];
        }

  $ids = explode(",",$_POST['Std_ID']);
  $ar = [];
  foreach($ids as $st){
    list($studentId, $worklod, $attendance) = explode('_', $st);
    $query=mysqli_multi_query($conn,"insert into attendancelist (StudentId,WorkloadId,Status) values ($studentId,$worklod,$attendance)");
                   
                   if ($query) {
                    $result = " data inserted successfully! ";
                   }
                   else{
                    $result = " No record added to the database! ";
                   }
                   echo $result;
  }
  echo json_encode($ar);
  return;
}