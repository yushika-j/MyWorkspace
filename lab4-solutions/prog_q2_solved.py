def mess(phrase):
     '''(str)->str
     Returns the a copy of the given phrase where
     each character that is one of the last  8 consonants
     of English alphabet is capitalized
     and where each space is replaced by a dash.
     '''
     new_phrase=''
     for ch in phrase:
          if ch in 'rstvwxyz':
               new_phrase=new_phrase+ch.capitalize()
          elif ch==' ':
               new_phrase=new_phrase+'-'
          else:
               new_phrase=new_phrase+ch
     return new_phrase
          
