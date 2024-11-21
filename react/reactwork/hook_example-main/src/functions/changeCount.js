export const ACTION_TYPE = {
  up : "INCREASE",
  down : "DECREASE"
}
// reducer = > state 관리 함수
export const reducer = (state, action) => {
  switch (action.type) {
    case ACTION_TYPE.up:
      if (state >= 10) {
        state = 10;
      } else {
        state += action.payload;
      }
      return state;
    case ACTION_TYPE.down:
      if (state <= 0) {
        state = 0;
      } else {
        state -= action.payload;
      }
      return state;
    default :
      return state;
  }
};