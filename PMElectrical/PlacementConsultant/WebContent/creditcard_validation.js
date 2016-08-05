function validate_creditcard(cname, cnumber)
{
	var card_name = cname;
	var card_number = cnumber;
	var invalid_card = 10;
	var error_message = new Array();
	error_message[0] = "invalid card type";
	error_message[1] = "Field is empty. Enter the card number";
	error_message[2] = "Invalid format of card number";
	error_message[3] = "This credit card is invalid";
	error_message[4] = "Give no. of digits correctly";
	
	var credit_cards = new Array();
	credit_cards[0] = {name:"Visa",
					   length:"13,16",
					   prefixes:"4",
					   checkdigit:true};

	credit_cards[1] = {name: "MasterCard", 
               		   length: "16",
               		   prefixes: "51,52,53,54,55",
               		   checkdigit: true};

	credit_cards[2] = {name: "DinersClub",
					   length: "14,16",
					   prefixes: "300,301,302,303,304,305,36,38,55",
					   checkdigit: true};
	
	credit_cards[3] = {name: "CarteBlanche",
				       length: "14",
				       prefixes: "300,301,302,303,304,305,36,38",
				       checkdigit: true};
	
	credit_cards[4] = {name: "AmEx", 
                       length: "15", 
               		   prefixes: "34,37",
        		       checkdigit: true};
	
	credit_cards[5] = {name: "Discover", 
             		   length: "16", 
               		   prefixes: "6011,650",
                	   checkdigit: true};
	
	credit_cards[6] = {name: "JCB", 
          		       length: "15,16", 
          		       prefixes: "3,1800,2131",
           			   checkdigit: true};
	
	credit_cards[7] = {name: "enRoute", 
          			   length: "15", 
                       prefixes: "2014,2149",
               		   checkdigit: true};
	
	credit_cards[8] = {name: "Solo", 
      			       length: "16,18,19", 
    		           prefixes: "6334, 6767",
 		               checkdigit: true};
	
	credit_cards[9] = {name: "Switch", 
   			           length: "16,18,19", 
               		   prefixes: "4903,4905,4911,4936,564182,633110,6333,6759",
               		   checkdigit: true};
	
	credit_cards[10] = {name: "Maestro", 
     		            length: "12,13,14,15,16,18,19", 
              			prefixes: "5018,5020,5038,6304,6759,6761",
               			checkdigit: true};
	
	credit_cards[11] = {name: "VisaElectron", 
    		            length: "16", 
               			prefixes: "417500,4917,4913",
               			checkdigit: true};    
               			
	var card_type = -1;
	for(var i = 0; i<credit_cards.length; i++)
	{
		if(card_name.toLowerCase()==credit_cards[i].name.toLowerCase())
		{
			card_type = i;		
			break;
		}
	}	

	if(card_type == -1)
	{
		invalid_card = 0;
		alert (error_message[invalid_card]);
	}

	if(card_number.length == 0)
	{
		invalid_card = 1;
		alert (error_message[invalid_card]);
	}

	card_number = card_number.replace(/^\s+$/g,"");

	var card_no = card_number;
	var card_exp = /^\d{13,19}$/;


	if(card_no.match(card_exp)==false)
	{
		invalid_card = 2;
		alert (error_message[invalid_card]);
	}
					
	
	if(credit_cards[card_type].checkdigit)
	{
		var checksum = 0;
		var char1 = "";
		var j = 1;
		var calc;
		for(i = card_number.length - 1; i>=0 ; i--)
		{
			calc = Number(card_number.charAt(i))*j;
			if(calc > 9)
			{
				checksum = checksum + 1;
				calc = calc - 10;
			}
			checksum = checksum + calc;
			if(j == 1)
			{
				j==2;
			}
			else
			{
				j==1;
			}
		}

		if(checksum  % 10 != 0)
		{			
			invalid_card = 3;
			alert(error_message[invalid_card]);
		}
	}
	
	var valid_length = false;
	var valid_prefix = false;
	var undefined;
	
	var prefix;
	var clength = new Array();
	
	prefix = credit_cards[card_type].prefixes.split("\,");
    
	for(i=0; i<prefix.length;i++)
	{
		exp = new RegExp("^"+prefix[i]);
		if(exp.test(card_no))
			valid_prefix = true;
	}

	if(valid_prefix == false)
	{
		invalid_card = 3;
		alert (error_message[invalid_card]);
	}

	clength = credit_cards[card_type].length.split(",");
	
	for(var j=0;j<clength.length;j++)
	{
		if(card_no.length == clength[j])
		valid_length = true;
	}

	if(valid_length == false)
	{
		invalid_card = 4;
		alert (error_message[invalid_card]);
	}
    if(invalid_card != 1 || invalid_card != 2 || invalid_card != 3 || invalid_card != 4)
    {
    	if(document.forms[0].cardnumber != "")
    	document.forms[0].pay.disabled = false;
    }    
}



