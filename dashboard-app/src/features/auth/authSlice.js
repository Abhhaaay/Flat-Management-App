import { createSlice } from '@reduxjs/toolkit'

export const authSlice = createSlice({
  name: 'auth',
  initialState: {
    email: '',
  },
  reducers: {
    setUserEmail: (state, action) => {
      state.email = action.payload;
    }
  },
})

export const { setUserEmail } = authSlice.actions

export default authSlice.reducer;