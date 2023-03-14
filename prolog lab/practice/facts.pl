intervalle(K,K,H):- K=<H.
intervalle(K,L,H):- L<H, L1 is L+1, intervalle(K,L1,H).