function viewHistory(){

    const table =
    document.getElementById("historyTable");

    table.innerHTML = `

    <tr>

        <td>25-07-2026</td>

        <td>Cash Deposit</td>

        <td>₹5,000</td>

        <td>Success</td>

    </tr>

    <tr>

        <td>24-07-2026</td>

        <td>Cash Withdrawal</td>

        <td>₹2,000</td>

        <td>Success</td>

    </tr>

    <tr>

        <td>22-07-2026</td>

        <td>Balance Enquiry</td>

        <td>--</td>

        <td>Viewed</td>

    </tr>

    <tr>

        <td>20-07-2026</td>

        <td>PIN Change</td>

        <td>--</td>

        <td>Success</td>

    </tr>

    `;

}