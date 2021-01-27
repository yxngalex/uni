<?PHP
     //Zadatak 1

    echo "Vase ime je : " . $_POST['ime'] . " .<br/>";

    echo "Vase prezime je : " . $_POST['prezime'] . ".<br/>";

    echo "Vas pol je : " . $_POST['pol'] . ".<br/>";

    $pPrilog = $_POST['prilog'];
        $temp = count($pPrilog);
        for($i = 0; $i < $temp; $i++)
        {
          echo("Vas prilog je " . $pPrilog[$i] . ". <br/> ");
        }

    //Zadatak 2
    
    $total = 0;
    $broj = 0;
    $unetBroj = $_POST['number'];

    while($broj <= $unetBroj) {
        if($broj % 2 == 1) {
            $total = $total + $broj;
        }
        $broj++;
    }

    echo "Suma svih nepranih brojeva od 1 do " . $unetBroj . " je : " .$broj;
?>