import string
def decrypt_with_mapping(ciphertext):
    # Mapping from cipher letters to plaintext letters
    cipher_to_plain = {
        'K': 'I', 'Z': 'W', 'R': 'A', 'N': 'S', 'G': 'T', 'J': 'H', 'I': 'N', 'P': 'K',
        'B': 'E', 'O': 'L', 'X': 'D', 'A': 'O', 'U': 'R', "W" : "P",
        'M': 'Y', 'E': 'M', 'S': 'G', 'V': 'J', 'T': 'V', 'L': 'U', "Q" : "J",
    }
    # Decrypted message initialization
    decrypted_message = []
    # Traverse each letter in the cipher text
    for char in ciphertext:
        if char in string.ascii_uppercase:
            decrypted_message.append(cipher_to_plain.get(char, char))
        else:
            decrypted_message.append(char)
    # Join the decrypted characters into a string
    return ''.join(decrypted_message)

# Given cipher text
cipher_text = ("KZRNK GJKIP ZBOOB XLCRG BXFAU GJBNG RIXRU XAFGJ BXRME MNKNG BURIX "
"KJRXR SBUER ISATB UIBNN RTBUM NBIGK EBIGR OCUBR GLUBN JBGRL SJGLN "
"GJBOR ISLRS BAFFO AZBUN RFAUS AGGBI NGLXM IAZRX RMNVL GEANG CJRUE "
"KISRM BOOAZ GLOKW FAUKI NGRIC BEBRI NJAWB OBNNO ATBZJ KOBRC JKIRR "
"NGBUE BRINK XKBAF QBROA LNMRG MALUF BBG")

decrypted_message = decrypt_with_mapping(cipher_text)
print(decrypted_message)
