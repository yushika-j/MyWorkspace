import nltk
from nltk.corpus import words

# Download the English words corpus
nltk.download('words')

# Common English digrams and trigrams for better validation
common_digrams = ['th', 'he', 'in', 'er', 'an', 're', 'nd', 'at', 'on', 'nt']
common_trigrams = ['the', 'and', 'tha', 'ent', 'ion', 'tio', 'for', 'nde', 'has']

# Function to decrypt a monoalphabetic substitution cipher using letter frequency analysis
def decrypt_monoalphabetic_cipher(S):
    # Load the English dictionary
    english_words = set(words.words())
    
    # Remove spaces from the cipher text and convert to uppercase
    S = S.replace(" ", "").upper()
    N = len(S)
    
    # Stores final 10 possible deciphered plaintexts
    plaintexts = [None] * 26
    
    # Store the frequency of each letter in cipher text
    freq = [0] * 26
    
    # Calculate the frequency of each letter in cipher text
    for char in S:
        if 'A' <= char <= 'Z':
            freq[ord(char) - 65] += 1
    
    # English letter frequency in descending order
    T = "ETAOINSHRDLCUMWFGYPBVKJXQZ"
    
    # Sort the frequency array in descending order and track indices
    freq_sorted = sorted(range(26), key=lambda k: freq[k], reverse=True)
    
    # Try the top 10 possible shifts based on frequency analysis
    for i in range(26):
        probable_shift = freq_sorted[i]
        current_shift = ord(T[i]) - 65 - probable_shift
        
        # Generate the ith possible plaintext by shifting characters
        curr_plaintext = ""
        for char in S:
            if 'A' <= char <= 'Z':
                shifted_char = (ord(char) - 65 + current_shift) % 26
                curr_plaintext += chr(shifted_char + 65)
        
        plaintexts[i] = curr_plaintext
    
    # Print the generated 10 possible plaintexts and check for valid words, digrams, and trigrams
    for i in range(10):
        print(f"This is the {i+1}th possible plaintext: ")
        print(plaintexts[i])
        print("\n")
        
        # Check if the plaintext contains valid English words
        words_in_plaintext = plaintexts[i].split()
        valid_words = [word for word in words_in_plaintext if word.lower() in english_words]
        
        # Check for common digrams and trigrams in the plaintext
        found_digrams = any(digram in plaintexts[i].lower() for digram in common_digrams)
        found_trigrams = any(trigram in plaintexts[i].lower() for trigram in common_trigrams)
        
        if len(valid_words) > 0 or found_digrams or found_trigrams:
            print("Valid English words found in the plaintext: ", valid_words)
            if found_digrams:
                print("Common English digrams found in the plaintext.")
            if found_trigrams:
                print("Common English trigrams found in the plaintext.")
        else:
            print("No valid English words, digrams, or trigrams found in the plaintext.")
        print("\n")

# Driver code

# Given cipher text string 
cipher_text = ("KZRNK GJKIP ZBOOB XLCRG BXFAU GJBNG RIXRU XAFGJ BXRME MNKNG BURIX "
               "KJRXR SBUER ISATB UIBNN RTBUM NBIGK EBIGR OCUBR GLUBN JBGRL SJGLN "
               "GJBOR ISLRS BAFFO AZBUN RFAUS AGGBI NGLXM IAZRX RMNVL GEANG CJRUE "
               "KISRM BOOAZ GLOKW FAUKI NGRIC BEBRI NJAWB OBNNO ATBZJ KOBRC JKIRR "
               "NGBUE BRINK XKBAF QBROA LNMRG MALUF BBG")

# Function call to decrypt the monoalphabetic cipher
decrypt_monoalphabetic_cipher(cipher_text)
