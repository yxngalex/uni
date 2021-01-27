export const filterUsers = (user: any, inputPar: string) => {
  return [user.ime, user.prezime, user.godine].some(prop => prop.toLowerCase().startsWith(inputPar.toLowerCase()));
};
