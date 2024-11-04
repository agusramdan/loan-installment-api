package com.agus.ramdan.loan.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

//@SpringBootTest
class ApplicationTests {
    @Test
    void testSend() {
        Assertions.assertTrue(BigDecimal.TEN.compareTo(BigDecimal.ONE) > 0);
        ;
    }

//    @Autowired
//    RpxDataAccountRepository rpxDataAccountRepository;
//    @Test
//	void testSend() {
//        rpxDataAccountRepository.findById("121212");
//    }

//	@Autowired
//	RpxAclEmailController emailRequestController;
//	@Test
//	void testSend()  {
//		val data = new HashMap<String, Object>();
//		data.put("recipient_name", "PT. Ganteng Pisan");
//		data.put("recipient_email", "agus.ramdan@gmail.com");
//		data.put("account_name", "GLOBAL DISTRIBUTION ALLIANCE, PT");
//		data.put("account_number", "758030992");
//		data.put("total_bill", "2,500,000");
//		data.put("collection_commpany_name", "PT. Sena Swatika");
//		data.put("jatuh_tempo", "23");
//		data.put("jatuh_tempo_txt", "dua puluh tiga");
//
//		val invoices = new ArrayList();
//		Map<String, Object> invoice;
//
//		invoice = new HashMap<>();
//		invoice.put("no", "1");
//		invoice.put("date", "1 October 2019");
//		invoice.put("due_date", "1 October 2019");
//		invoice.put("number", "123456");
//		invoice.put("status", "Active");
//		invoice.put("amount", "1,500,000");
//		invoices.add(invoice);
//
//		invoice = new HashMap<>();
//		invoice.put("no", "2");
//		invoice.put("date", "1 October 2019");
//		invoice.put("due_date", "1 October 2019");
//		invoice.put("number", "123457");
//		invoice.put("status", "Active");
//		invoice.put("amount", "1,000,000");
//		invoices.add(invoice);
//
//		data.put("invoices", invoices);
//		ObjectMapper mapper = new ObjectMapper();
//		val request = RpxAclRequest.builder()
//				.data(mapper.convertValue(data, JsonNode.class))
//				.build();
//		emailRequestController.generateAcl("ACNL",request);
//
//	}
//	@Autowired
//	SmtpService smtpService;
//	@Test
//	void testSend()  {
//		val data = new HashMap<String, Object>();
//		data.put("recipient_name", "PT. Ganteng Pisan");
//		data.put("recipient_email", "agus.ramdan@gmail.com");
//		data.put("account_name", "GLOBAL DISTRIBUTION ALLIANCE, PT");
//		data.put("account_number", "758030992");
//		data.put("total_bill", "2,500,000");
//		data.put("collection_commpany_name", "PT. Sena Swatika");
//		data.put("jatuh_tempo", "23");
//		data.put("jatuh_tempo_txt", "dua puluh tiga");
//
//		val invoices = new ArrayList();
//		Map<String, Object> invoice;
//
//		invoice = new HashMap<>();
//		invoice.put("no", "1");
//		invoice.put("date", "1 October 2019");
//		invoice.put("due_date", "1 October 2019");
//		invoice.put("number", "123456");
//		invoice.put("status", "Active");
//		invoice.put("amount", "1,500,000");
//		invoices.add(invoice);
//
//		invoice = new HashMap<>();
//		invoice.put("no", "2");
//		invoice.put("date", "1 October 2019");
//		invoice.put("due_date", "1 October 2019");
//		invoice.put("number", "123457");
//		invoice.put("status", "Active");
//		invoice.put("amount", "1,000,000");
//		invoices.add(invoice);
//
//		data.put("invoices", invoices);
//		val request = EmailRequest.builder()
//				.rid("10000")
//				.template("mail/html/email-collection-notice-letter.html")
//				.subject("Collection Notice Letter PT. Ganteng Pisan")
//				.to("agus.ramdan@gamil.com")
//				.data(data)
//				.build();
//		smtpService.generateEmail(request);
//	}
//	@Test
//	void contextLoads() throws MessagingException {
//		var targetEmail = "agus.ramdan@smartdata-solusi.com ; agus.ramdan@gmail.com ; iman@smartdata-solusi.com";
//		sendingController.sendCollectionHtmlMail(
//				"PT. Ganteng Pisan",
//				targetEmail,
//				Locale.getDefault());
//
//		sendingController.sendCollectionRemainderHtmlMail(
//				"PT. Ganteng Pisan",
//				targetEmail,
//				Locale.getDefault());
//
//		sendingController.sendCashlistHtmlMail(
//				"PT. Ganteng Pisan",
//				targetEmail,
//				Locale.getDefault());
//
//	}


}
