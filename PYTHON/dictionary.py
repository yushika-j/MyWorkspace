import collections

# Frequency analysis of the English language (most common to least common)
english_freq = 'ETAOINSHRDLCUMWFGYPBVKJXQZ'

# Function to decrypt with the current letter mappings
def decrypt_with_mapping(ciphertext, mapping):
    # Decrypt by replacing letters according to the current mapping
    decrypted_text = ''.join([mapping.get(letter, letter) for letter in ciphertext])
    return decrypted_text

# Initialize the ciphertext
ciphertext = "KZRNK GJKIP ZBOOB XLCRG BXFAU GJBNG RIXRU XAFGJ BXRME MNKNG BURIX KJRXR SBUER ISATB UIBNN RTBUM NBIGK EBIGR OCUBR GLUBN JBGRL SJGLN GJBOR ISLRS BAFFO AZBUN RFAUS AGGBI NGLXM IAZRX RMNVL GEANG CJRUE KISRM BOOAZ GLOKW FAUKI NGRIC BEBRI NJAWB OBNNO ATBZJ KOBRC JKIRR NGBUE BRINK XKBAF QBROA LNMRG MALUF BBG"

# Frequency analysis of the ciphertext
cipher_freq = collections.Counter(ciphertext.replace(" ", ""))
print("Ciphertext frequency:", cipher_freq)

# Initialize the mapping dictionary (cipher letter to plaintext letter)
mapping = {}

# Interactive process for replacing one letter at a time
while True:
    # Show current decryption
    decrypted_text = decrypt_with_mapping(ciphertext, mapping)
    print("\nCurrent decryption:", decrypted_text)

    # Prompt the user for input
    cipher_letter = input("\nEnter the cipher letter to replace (or 'exit' to stop): ").upper()
    if cipher_letter == 'EXIT':
        break
    plain_letter = input(f"Replace '{cipher_letter}' with: ").upper()

    # Update the mapping
    mapping[cipher_letter] = plain_letter

    # Show the current letter mapping
    print("\nCurrent letter mapping:", mapping)
