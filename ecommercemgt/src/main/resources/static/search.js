function search() {
    var input, filter, table, tr, td, i, j, txtValue;
    input = document.getElementById("searchBar");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    // Check if the input element is found
    if (!input) {
        console.error("Search bar element with id 'searchBar' not found.");
        return;
    }

    // Check if the table element is found
    if (!table) {
        console.error("Table element with id 'myTable' not found.");
        return;
    }

    // Loop through all table rows (except the first, which contains table headers)
    for (i = 1; i < tr.length; i++) {
        tr[i].style.display = "none";  // Initially hide the row
        td = tr[i].getElementsByTagName("td");

        // Loop through each cell in the current row
        for (j = 0; j < td.length; j++) {
            if (td[j]) {
                txtValue = td[j].textContent || td[j].innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";  // Show the row if a match is found
                    break;  // No need to check other cells in this row
                }
            }
        }
    }
}
