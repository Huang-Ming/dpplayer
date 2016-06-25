try
		{
			//ro.product.brand=Unblocktech
			//ro.product.model=Global_Edition_S800
			//password
			//GetMac
			//getCpuID
			//ro.build.id=KOT49H
			//ro.product.device=dolphin-fvd-p1
			//ro.product.manufacturer=Unblocktech
			//ro.product.board=exdroid
			//ro.product.name=dolphin_fvd_p1
			String v11 =  "80C3C34E578EF240EEAA1113EC8BE6E4BAF4B677963D83253B0E9A96C39D8ADD9C0984952E7E8889BD56F324D36FC88F32340D6DD6CDE99D98B6441945E750A2204397916621CBCB3B400ABA7991B6482EF8467F3679A1D08273C5321A28486E4D766908563D1CB9865337A825579C17B5D0B29A6356D6FE0E092FC2952B6CF98385D894CB60969171F07B1E0B7190B91F749D14FEBB989D2C012304B0056C24C63B48BCCCCBBC7047D1C4BD5612E14A79092FFE76552A0A2C1782689152D49676F738B334E4F82445428A80F2DC87E5858931ED1ECC5A8A89B884B31D71EB26FE708728CB487D9C1A6D1C28F0E5DF836B003AD85351D4576834D765151A3EB6F44E1A2202BDB07634ECAE455CD93BAB1FE3EE5E48BFE49D649A2EAFABC58D6261AA3D43C0D00978ECC6FF9E51BCF2CCC354D16A2D406ACCC6BDE32A135BA9CC0D31062BE907AD244B15468EA1925E1BD9EF39612DC117365DD3AD9F5865E5C8CE9072801E67F6E51FC394EF4D19492BD73A833EEFC84A0EB43499562C3BF71C198EFAA12E158C3CF55C1ED2B18FC8923EA2212DBE286A7DCB9BA0D60788FED6441F7B88B0FBBB9A502676A4D15A3F1B49637758F7A127455C696F7206E35700";

			String v8 = new String(decrypt2("72ABDDF28FE5CF8B".getBytes(),
					hexStringToByte(v11)), "UTF-8");

			String[] v81 = v8.split("\\|");

			v81[0] = "Unblocktech";
			v81[1] = "Global_Edition_S800";
			v81[5] = "KOT49H";
			v81[6] = "dolphin-fvd-p1";
			v81[7] = "Unblocktech";
			v81[8] = "exdroid";
			v81[9] = "dolphin_fvd_p1";

			StringBuilder sb = new StringBuilder();
			for (String v:v81) {
				sb.append(v);
				sb.append("|");
			}

			String ti = byteArrayToHexString(encrypt2("72ABDDF28FE5CF8B".getBytes(),sb.toString().getBytes()));
			int tttttt = ti.length();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}



    private static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) throws Exception {
    		SecretKeySpec v1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    		Cipher v0 = Cipher.getInstance("AES");
    		v0.init(2, ((Key)v1), new IvParameterSpec(new byte[v0.getBlockSize()]));
    		return v0.doFinal(paramArrayOfByte2);
    	}

    	public static byte[] hexStringToByte(String hex) {
    		int v2 = hex.length() / 2;
    		byte[] v4 = new byte[v2];
    		char[] v0 = hex.toCharArray();
    		int v1;
    		for(v1 = 0; v1 < v2; ++v1) {
    			int v3 = v1 * 2;
    			v4[v1] = ((byte)(toByte(v0[v3]) << 4 | toByte(v0[v3 + 1])));
    		}

    		return v4;
    	}

    	private static byte toByte(char c) {
    		return ((byte)"0123456789ABCDEF".indexOf(c));
    	}


    	private static byte[] decrypt2(byte[] raw, byte[] encrypted) throws Exception {
    		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    		Cipher cipher = Cipher.getInstance("AES");
    		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    		byte[] decrypted = cipher.doFinal(encrypted);
    		return decrypted;
    	}

    	private static byte[] encrypt2(byte[] raw, byte[] clear) throws Exception {
    		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    		Cipher cipher = Cipher.getInstance("AES");
    		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
    		byte[] encrypted = cipher.doFinal(clear);
    		return encrypted;
    	}

    	private static String byteArrayToHexString(byte[] bytearray) {
    		StringBuilder sb = new StringBuilder();
    		for (byte bb:bytearray) {
    			sb.append(byteToHexString(bb));
    		}
    		return sb.toString();
    	}

    	private static String byteToHexString(byte ib) {
    		char[] v0 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
    				'E', 'F'};
    		return new String(new char[]{v0[ib >>> 4 & 15], v0[ib & 15]});
    	}

    	private static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) throws Exception {
    		SecretKeySpec v1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    		Cipher v0 = Cipher.getInstance("AES");
    		v0.init(1, ((Key)v1), new IvParameterSpec(new byte[v0.getBlockSize()]));
    		return v0.doFinal(paramArrayOfByte2);
    	}
