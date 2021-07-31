package org.project.cipher.utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CipherTest {

	Cipher cipher;
	@BeforeEach
	void setUp() {
		cipher = new Cipher();
	}

	@Test
	@DisplayName("Encrypt uppercase text")
	void do_EncodeUppercase() {
		assertEquals("FPFVDVA", cipher.encode("ENCRYPT"));
	}

	@Test
	@DisplayName("Encrypt lowercase text")
	void do_EncodeLowercase() {
		assertEquals("fpfvdva", cipher.encode("encrypt"));
	}

	@Test
	@DisplayName("Encrypt uppercase text")
	void do_DecodeUppercase() {
		assertEquals("ENCRYPT", cipher.decode("FPFVDVA"));
	}

	@Test
	@DisplayName("Encrypt lowercase text")
	void do_DecodeLowercase() {
		assertEquals("encrypt", cipher.decode("fpfvdva"));
	}
}
